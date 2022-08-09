package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private IService userService;

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity US001(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        this.userService.follow(userId, userIdToFollow);
        return new ResponseEntity(HttpStatus.OK);
    }


    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count")
    public void US002(){

    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
    @GetMapping("/users/{userId}/followers/list")
    public void US003(){

    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<List<FollowedListResDTO>> US004(@PathVariable Integer userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(this.userService.listFollowed(userId, order.orElse(null)), HttpStatus.OK);
    }

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    public void US005(){

    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @PostMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<PostResDTO>> US006(@PathVariable Integer userId){
        return new ResponseEntity<>(this.userService.listFollowersPosts(userId), HttpStatus.OK);
    }

    //US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public void US007(){

    }

    //US 0008: Ordenamiento alfabético ascendente y descendente
    //      users/{UserID}/followers/list?order=name_asc
    //      users/{UserID}/followers/list?order=name_desc
    //      users/{UserID}/followed/list?order=name_asc
    //      users/{UserID}/followed/list?order=name_desc
    //  *Nota: Este ordenamiento aplica solo para US-003 y US-004.
    @GetMapping("/US008") //Cambiar Endpoint
    public void US008(){

    }

    //US 0009: Ordenamiento por fecha ascendente y descendente
    //     products/followed/{userId}/list?order=date_asc
    //     products/followed/{userId}/list?order=date_desc
    //  *Nota: Este ordenamiento aplica solo para la US-006
    @GetMapping("US009") //Cambiar Endpoint
    public void US009(){

    }

    /* B_Requerimientos_incrementales */

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public void US0010(){

    }

    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/count?user_id={userId}")
    public void US0011(){

    }

    /* C_Ejemplo_Requerimiento_Bonus */

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/list?user_id={userId}")
    public void US0012(){

    }
}
