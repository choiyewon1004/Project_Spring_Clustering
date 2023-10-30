package com.example.project_spring_clustering.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RDTO {

    private int route_code;
    private String route_nm;
    private Double route_lng;
    private Double route_lat;
    private String route_type;

    public RDTO(int c, String n, Double t, Double g, String ty){
        this.setRoute_code(c);
        this.setRoute_nm(n);
        this.setRoute_lng(g);
        this.setRoute_lat(t);
        this.setRoute_type(ty);


    }

}
