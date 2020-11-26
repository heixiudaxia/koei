package com.yl.hz.convert;

import org.springframework.beans.BeanUtils;

public class CharactarConverter {

    public static CharactarDTO DO2DTO(CharactarDO DO) {
        CharactarDTO DTO = new CharactarDTO();
        DTO.setAge(String.valueOf(DO.getAge()));
        DTO.setName(DO.getName());
        return DTO;
    }

    public static CharactarDTO copy(CharactarDO DO) {
        CharactarDTO charactarDTO = new CharactarDTO();
        BeanUtils.copyProperties(DO, charactarDTO);
        return charactarDTO;
    }

}
