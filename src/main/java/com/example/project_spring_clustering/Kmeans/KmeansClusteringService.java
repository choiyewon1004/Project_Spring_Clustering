package com.example.project_spring_clustering.Kmeans;

import com.example.project_spring_clustering.DTO.ClusteringRequest;
import com.example.project_spring_clustering.DTO.ClusteringResult;
import com.example.project_spring_clustering.DTO.GeoPoint;
import com.example.project_spring_clustering.DTO.RDTO;

import java.util.List;
import java.util.Map;

public interface KmeansClusteringService {

    List<ClusteringResult> getClusteringResult(Map<GeoPoint, RDTO> GEO_POINT_MAP);

    List<ClusteringResult> createClustering(List<ClusteringRequest> clusteringRequestList);
}