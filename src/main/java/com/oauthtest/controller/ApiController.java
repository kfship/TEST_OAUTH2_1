package com.oauthtest.controller;


import com.oauthtest.bean.User;
import com.oauthtest.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
//@RequestMapping("/api/user")
public class ApiController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    PagedResourcesAssembler<User> pagedResourcesAssembler;

    @GetMapping(value = "/userInfo/{userId}")
    public @ResponseBody
    PagedResources<User> testEx(
            @PathVariable("userId") String userId,
            PersistentEntityResourceAssembler persistentEntityResourceAssembler,
            Pageable pageable) {

        Specification<User> spec = new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();
                predicate.add(criteriaBuilder.equal(root.get("userId"), userId));

                return criteriaBuilder.and(predicate.toArray(new Predicate[0]));
            }
        };

        Page<User> pageUsers = userAuthRepository.findAll(spec, pageable);
        return pagedResourcesAssembler.toResource(pageUsers, (ResourceAssembler) persistentEntityResourceAssembler);

    }

}
