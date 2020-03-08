package com.oauthtest.controller;

import com.oauthtest.bean.User;
import com.oauthtest.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/*

@RestController 를 사용한 경우
  - data.rest.base-path 를 사용했을 때 Controller에 설정한 RequestMapping을 인식하지 못함

@RepositoryRestController 를 사용한 경우
  - @RepositoryRestResource 사용하 자동 사용된 api를 override 하니 잘 작동되지 않는 문제가 있었음 (다시 테스트 필요함)
  - Repository 에 설정한 Projection을 적용하기 위해서는 PersistentEntityResourceAssembler를 이용해서 PapgedResources 를 반환해야 함
  - PersistentEntityResourceAssembler 는 @RepositoryRestController 어노테이션을 사용하지 않았을 때는 사용 불가함
  - @RepositoryRestController 를 사용했다고 하더라도 단순한 String만 반환했을 때는 오류 발생함, @ResponseBody를 추가 후 오류 사라짐

*/


//@RestController
@RepositoryRestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    PagedResourcesAssembler<User> pagedResourcesAssembler;

    @GetMapping(value = "/{userId}")
    public @ResponseBody PagedResources<User> testEx(
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


