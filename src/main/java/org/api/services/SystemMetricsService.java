package org.api.services;

import org.api.DTO.*;
import org.api.exception.MetricsException;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;

import java.io.File;
import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SystemMetricsService {

        private final SystemInfo systemInfo = new SystemInfo();

        public HealthResponse getHealth() {
            try {
                var os = systemInfo.getOperatingSystem();

                return new HealthResponse(
                        "UP",
                        InetAddress.getLocalHost().getHostName(),
                        os.getFamily(),
                        os.toString(),
                        now()
                );

            } catch (Exception e) {
                throw new MetricsException("Unable to read health metrics");
            }
        }

        public CpuResponse getCpu() {
            try {
                var processor = systemInfo.getHardware().getProcessor();

                long[] ticks = processor.getSystemCpuLoadTicks();
                sleep(1000);
                double cpuLoad = processor.getSystemCpuLoadBetweenTicks(ticks) * 100;

                return new CpuResponse(
                        round(cpuLoad),
                        processor.getLogicalProcessorCount(),
                        processor.getPhysicalProcessorCount(),
                        now()
                );

            } catch (Exception e) {
                throw new MetricsException("Unable to read CPU metrics");
            }
        }

        public MemoryResponse getMemory() {
            try {
                var memory = systemInfo.getHardware().getMemory();

                double total = bytesToGb(memory.getTotal());
                double free = bytesToGb(memory.getAvailable());
                double used = total - free;
                double percent = (used / total) * 100;

                return new MemoryResponse(
                        round(total),
                        round(used),
                        round(free),
                        round(percent),
                        now()
                );

            } catch (Exception e) {
                throw new MetricsException("Unable to read memory metrics");
            }
        }
        public DiskResponse getDisk() {
            try {
                File root = new File("/");

                double total = bytesToGb(root.getTotalSpace());
                double free = bytesToGb(root.getFreeSpace());
                double used = total - free;
                double percent = (used / total) * 100;

                return new DiskResponse(
                        round(total),
                        round(used),
                        round(free),
                        round(percent),
                        now()
                );

            } catch (Exception e) {
                throw new MetricsException("Unable to read disk metrics");
            }
        }

        public AllMetricsResponse getAll() {
            try {
                return new AllMetricsResponse(
                        getHealth(),
                        getCpu(),
                        getMemory(),
                        getDisk()
                );

            } catch (Exception e) {
                throw new MetricsException("Unable to read all metrics");
            }
        }


        private String now() {
            return ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        }

        private void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    public HealthResponse getHealth2() {
        throw new MetricsException("Unable to read health metrics");
    }
    public CpuResponse getCpu2() {
        throw new MetricsException("Unable to read CPU metrics");
    }
    public MemoryResponse getMemory2() {
        throw new MetricsException("Unable to read memory metrics");
    }
    public DiskResponse getDisk2() {
        throw new MetricsException("Unable to read disk metrics");
    }
    public AllMetricsResponse getAll2() {
        throw new MetricsException("Unable to read all metrics");
    }
        private double bytesToGb(long bytes) {
            return bytes / 1024.0 / 1024.0 / 1024.0;
        }

        private double round(double val) {
            return Math.round(val * 100.0) / 100.0;
        }
}
