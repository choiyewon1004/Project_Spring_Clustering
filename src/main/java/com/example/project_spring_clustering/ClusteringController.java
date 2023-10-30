package com.example.project_spring_clustering;

import com.example.project_spring_clustering.DTO.ClusteringResult;
import com.example.project_spring_clustering.DTO.GeoPoint;
import com.example.project_spring_clustering.DTO.RDTO;
import com.example.project_spring_clustering.Kmeans.KmeansClusteringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/clustering/view/v1_0")
@RequiredArgsConstructor
public class ClusteringController {
    private final    KmeansClusteringService kmeansClusteringService ;

    @GetMapping(path = "/kmeans")
    public ModelAndView login(Locale locale) {
        return new ModelAndView("home.html");
    }

    @GetMapping(path = "/test")
    public String test(Model model) {

        Map<GeoPoint, RDTO> data = make_data(init_dummy_data());
        System.out.println("log: here to check test");
//        for(int i=0;i<data.size();i++){
//            System.out.println(data.values().stream().toList().get(i).getRoute_nm());
//        }
        System.out.println("log: init data size : "+ data.size());

        List<ClusteringResult> result = kmeansClusteringService.getClusteringResult(data);
        for(int i=0;i<result.size();i++){
            System.out.println("log: "+result.get(i).getGroupId());
            for(int j=0;j<result.get(i).getClusteringLocationList().size();j++){
                System.out.println("log: "+result.get(i).getClusteringLocationList());

            }
        }


        return "home";
    }

    public List<RDTO> init_dummy_data(){
        RDTO r1 = new RDTO(1,"회사", 37.503341, 127.049840,"bus");
        RDTO r2 = new RDTO(2,"마담밍", 37.503624, 127.050337,"bus");
        RDTO r3 = new RDTO(3,"농민백암순대", 37.503829, 127.052980,"bus");
        RDTO r4 = new RDTO(4,"연더그레이", 37.503261, 127.050715,"bus");
        RDTO r5 = new RDTO(5,"집", 37.532918, 126.900196,"sub");
        RDTO r6 = new RDTO(6,"다이소", 37.534216, 126.900980,"sub");
        RDTO r7 = new RDTO(7,"삼성래미안", 37.532254, 126.903022,"sub");
        RDTO r8 = new RDTO(8,"당산서중학교", 37.532065, 126.898589,"sub");

        List<RDTO> data = new ArrayList<>();
        data.add(r1);data.add(r2);data.add(r3);data.add(r4);data.add(r5);data.add(r6);data.add(r7);data.add(r8);

        return data;
    }

    public Map<GeoPoint, RDTO> make_data(List<RDTO> dummy_data){
        final Map<GeoPoint, RDTO> GEO_POINT_MAP = new HashMap<>();

        for(int i=0;i<dummy_data.size();i++){
            GEO_POINT_MAP.put( GeoPoint.of(dummy_data.get(i).getRoute_lat(),dummy_data.get(i).getRoute_lng()) , dummy_data.get(i));
        }

        System.out.println(GEO_POINT_MAP);

        return GEO_POINT_MAP;
    }
}
