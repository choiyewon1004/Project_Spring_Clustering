package com.example.project_spring_clustering.Kmeans;

import com.example.project_spring_clustering.DTO.ClusteringRequest;
import com.example.project_spring_clustering.DTO.ClusteringResult;
import com.example.project_spring_clustering.DTO.GeoPoint;
import com.example.project_spring_clustering.DTO.RDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/clustering/api/v1_0/kmeans")
@RequiredArgsConstructor
public class KmeansController {
    private final KmeansClusteringService kmeansClusteringService;

//    @GetMapping
//    public List<ClusteringResult> getClusteringResult(){
//        System.out.println("getClusteringResult()");
//        return kmeansClusteringService.getClusteringResult(data);
//    }
//
//    @PostMapping
//    public List<ClusteringResult> createClustering(@RequestBody List<ClusteringRequest> clusteringRequestList){
//        return kmeansClusteringService.createClustering(clusteringRequestList);
//    }



}