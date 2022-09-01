package com.example.ejemplorelaciones.services;

import com.example.ejemplorelaciones.dto.CartDto;
import com.example.ejemplorelaciones.model.Cart;
import com.example.ejemplorelaciones.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CartService implements iCartService{

    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }

    @Override
    public CartDto save(CartDto cartDto) {
        ModelMapper modelMapper = new ModelMapper();
        Cart cart= modelMapper.map(cartDto,Cart.class);
        cart.getItems().forEach((i)->i.setPepe(cart));
        Cart cart2 = cartRepository.save(cart);
        CartDto response = modelMapper.map(cart2,CartDto.class);
        return response;
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }
}
