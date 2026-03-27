package org.api.DTOMetier;

public class AllMetricsResponse {
    private HealthResponse host_info;
    private CpuResponse cpu_info;
    private MemoryResponse memory_info;
    private DiskResponse disk_info;

    public AllMetricsResponse() {}

    public AllMetricsResponse(HealthResponse host_info, CpuResponse cpu_info,
                              MemoryResponse memory_info, DiskResponse disk_info) {
        this.host_info = host_info;
        this.cpu_info = cpu_info;
        this.memory_info = memory_info;
        this.disk_info = disk_info;
    }

    public HealthResponse getHost_info() { return host_info; }
    public void setHost_info(HealthResponse host_info) { this.host_info = host_info; }

    public CpuResponse getCpu_info() { return cpu_info; }
    public void setCpu_info(CpuResponse cpu_info) { this.cpu_info = cpu_info; }

    public MemoryResponse getMemory_info() { return memory_info; }
    public void setMemory_info(MemoryResponse memory_info) { this.memory_info = memory_info; }

    public DiskResponse getDisk_info() { return disk_info; }
    public void setDisk_info(DiskResponse disk_info) { this.disk_info = disk_info; }
}
