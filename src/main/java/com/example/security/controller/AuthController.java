package com.example.security.controller;

import com.example.security.domain.Usuario;
import com.example.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = {"/","/login"})
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView();
        Usuario usuario =  new Usuario();
        mav.addObject("usuario",usuario);
        mav.setViewName("register");
        return mav;
    }
    @PostMapping("/register")
    public ModelAndView registerUser(@Valid Usuario usuario, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView mav = new ModelAndView();
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors().toString());
            mav.addObject("successMessage","Por favor correija los errores");
            modelMap.addAttribute("bidingResult",bindingResult);
        }else if(usuarioService.isUserAlreadyPresent(usuario)){
            mav.addObject("successMessage","El usuario ya existe");
        }else{
            usuarioService.save(usuario);
            mav.addObject("successMessage","Usuario Registrado");
        }
        mav.addObject("usuario",new Usuario());
        mav.setViewName("register");
        return mav;
    }
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
    @GetMapping("/admin")
    public ModelAndView adminHome(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        return mav;
    }

}
