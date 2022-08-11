package com.bootcamp.be_java_hisp_w16_g06.controller;


import com.bootcamp.be_java_hisp_w16_g06.dto.*;
import com.bootcamp.be_java_hisp_w16_g06.service.ISocialMeliServiceE3;
import com.bootcamp.be_java_hisp_w16_g06.service.SocialMeliServiceE1;
import com.bootcamp.be_java_hisp_w16_g06.service.SocialMeliServiceE2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SocialMeliController {

    @Autowired
    ISocialMeliServiceE3 socialMaMeliServiceE3;
    @Autowired
    SocialMeliServiceE1 serviceE1;
    @Autowired
    SocialMeliServiceE2 service2;

    @GetMapping
    public ResponseEntity<ResponseDTO> test() {
        return new ResponseEntity<>(new ResponseDTO("Message Accepted", 200), HttpStatus.valueOf(200));
    }

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDTO> US001(@PathVariable int userId, @PathVariable int userIdToFollow) {
        ResponseDTO responseFollow = serviceE1.followUser(new FollowIdDto(userId, userIdToFollow));
        return new ResponseEntity<>(responseFollow, HttpStatus.valueOf(responseFollow.getStatusCode()));
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> US002(@PathVariable int userId) {
        return new ResponseEntity<>(service2.userFollowers(userId), HttpStatus.OK);
    }


    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> US003(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<FollowersDTO>(service2.userFollowersOrder(userId, order), HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> US004(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<FollowedDTO>(service2.userFollowed(userId, order), HttpStatus.OK);
    }

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    public ResponseEntity<ResponseDTO> US005(@RequestBody RequestPostDTO dto) {
        socialMaMeliServiceE3.createPost(dto);
        return new ResponseEntity<>(new ResponseDTO("", 200), HttpStatus.valueOf(200));
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ResponsePostDTO> US006(@PathVariable int userId, @RequestParam(required = false) String order) {
        ResponsePostDTO response = socialMaMeliServiceE3.getAllPost(userId, order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ResponseDTO> US007(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        ResponseDTO responseUnfollow = serviceE1.unFollowUser(new FollowIdDto(userId, userIdToUnfollow));
        return new ResponseEntity<>(responseUnfollow, HttpStatus.valueOf(responseUnfollow.getStatusCode()));
    }

    //US 0008: Ordenamiento alfabético ascendente y descendente
    //      users/{UserID}/followers/list?order=name_asc
    //      users/{UserID}/followers/list?order=name_desc
    //      users/{UserID}/followed/list?order=name_asc
    //      users/{UserID}/followed/list?order=name_desc
    //  *Nota: Este ordenamiento aplica solo para US-003 y US-004.

    //US 0009: Ordenamiento por fecha ascendente y descendente
    //     products/followed/{userId}/list?order=date_asc
    //     products/followed/{userId}/list?order=date_desc
    //  *Nota: Este ordenamiento aplica solo para la US-006

    /* B_Requerimientos_incrementales */
    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public ResponseEntity<ResponseDTO> US0010(@RequestBody RequestPostPromoDTO dto) {
        socialMaMeliServiceE3.createPostPromo(dto);
        return new ResponseEntity<>(new ResponseDTO("", 200), HttpStatus.valueOf(200));
    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<ResponsePostPromoDto> US0011(@RequestParam int userId) {
        return new ResponseEntity<>(socialMaMeliServiceE3.getAllPostPromo(userId), HttpStatus.OK);
    }

    /* C_Ejemplo_Requerimiento_Bonus */
    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public void US0012() {

    }

}
