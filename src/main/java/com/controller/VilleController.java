package com.controller;


import com.blo.VilleBLO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleController {
    @Autowired
    VilleBLO villeBLOService;

    @RequestMapping(value="/ville", method= RequestMethod.GET)
    public String get(@RequestParam(required = false, value="codePostal") String param){
        System.out.println("get : " + param);
        System.out.println(villeBLOService.getInfoVille(param));
        return villeBLOService.getInfoVille(param);
    }
}
