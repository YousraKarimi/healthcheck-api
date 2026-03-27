package org.api.controllers;

import org.api.DTOMetier.*;
import org.api.services.SystemMetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MonitoringController {

        private final SystemMetricsService service;

        public MonitoringController(SystemMetricsService service) {
            this.service = service;
        }

        @GetMapping("/health")
        public HealthResponse health() {return service.getHealth();}
        @GetMapping("/cpu")
        public CpuResponse cpu() {return service.getCpu();}
        @GetMapping("/memory")
        public MemoryResponse memory() {return service.getMemory();}
        @GetMapping("/disk")
        public DiskResponse disk() {return service.getDisk();}
        @GetMapping("/all")
        public AllMetricsResponse all() {
            return service.getAll();
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////
        @GetMapping("/healthError")
        public HealthResponse health2() {return service.getHealth2();}
        @GetMapping("/cpuError")
        public CpuResponse cpu2() {return service.getCpu2();}
        @GetMapping("/memoryError")
        public MemoryResponse memory2() {return service.getMemory2();}
        @GetMapping("/diskError")
        public DiskResponse disk2() {
        return service.getDisk2();
    }
        @GetMapping("/allError")
        public AllMetricsResponse all2() {
        return service.getAll2();
    }
}
