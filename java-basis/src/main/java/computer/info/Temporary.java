package computer.info;

import lombok.extern.slf4j.Slf4j;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 获取电脑设备温度信息
 * @author: shilh
 * @time 2022/7/31 16:14
 */

@Slf4j
public class Temporary {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();

        // 获取操作系统相关信息
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        log.info("获取操作系统信息：【{}】", operatingSystem.toString());

        // 获取进程信息
//        OSProcess process = operatingSystem.getProcess(1121);

        // 获取进程id list内存进程
        List<OSProcess> process1 = operatingSystem.getProcesses(new ArrayList<>());
        log.info("内存进程信息：【{}】", process1.toArray());

        // 获取系统总线程 线程句柄书
        int threadCount = operatingSystem.getThreadCount();
        log.info("总线程数：【{}】", threadCount);

        // 获取系统启动时间
        long systemBootTime = operatingSystem.getSystemBootTime();
        log.info("操作系统启动时间：【{}】", systemBootTime);

        // 获取操作系统版本
        OperatingSystem.OSVersionInfo operatingSystemVersion = operatingSystem.getVersionInfo();
        log.info("获取操作系统版本：【{}】", operatingSystemVersion.toString());


        int bitness = operatingSystem.getBitness();
        log.info("操作系统位数：【{}】", bitness);

        // 获取指定线程下的子线程
//        List<OSProcess> childProcess = operatingSystem.getChildProcesses(1, 2, OperatingSystem.ProcessSorting.CPU_DESC);

        // 获取操作系统类别
        String family = operatingSystem.getFamily();
        log.info("操作系统是：【{}】", family);

        // 获取操作系统下所有分区信息 文件系统分区、剩余空间、挂在信息、信息存储
        FileSystem fileSystem = operatingSystem.getFileSystem();
        List<OSFileStore> fileStore = fileSystem.getFileStores();
        log.info("操作系统分区信息：【{}】", fileStore);

        // 操作系统厂家
        String manufacturer = operatingSystem.getManufacturer();
        log.info("操作系统厂商信息：【{}】", manufacturer);

        // 获取网络参数： 网卡信息、dns、域名、ip

        NetworkParams networkParams = operatingSystem.getNetworkParams();
        String[] dnsServer = networkParams.getDnsServers();
        String domainName = networkParams.getDomainName();
        String hostName = networkParams.getHostName();
        String ip4 = networkParams.getIpv4DefaultGateway();
        String ip6 = networkParams.getIpv6DefaultGateway();
        log.info("dns信息：【{}】，域名：【{}】，主机名：【{}】，ip4【{}】，ip6：【{}】", dnsServer.toString(), domainName, hostName, ip4, ip6);


        // 硬件相关信息
        HardwareAbstractionLayer hardware = systemInfo.getHardware();

        // 获取电脑BIOS系统相关信息
        ComputerSystem computerSystem = hardware.getComputerSystem();
        Firmware firmware = computerSystem.getFirmware();
        log.info("bios name：【{}】",firmware.getName());
        log.info("bios desc：【{}】",firmware.getDescription());
        log.info("bios ：【{}】",firmware.getManufacturer());
        log.info("bios version：【{}】",firmware.getVersion());
        log.info("bios release date：【{}】",firmware.getReleaseDate());


        // 获取传感器信息
        Sensors sensors = hardware.getSensors();
        int[] sensorsFanSpeeds = sensors.getFanSpeeds(); // 获取风扇速度
        double senorsCpuVolTage = sensors.getCpuVoltage();  // 获取cpu电压
        double senorsCpuTemperature = sensors.getCpuTemperature(); // 获取cpu温度

        log.info("cpu 风扇速度：【{}】，cpu电压：【{}】，cpu温度：【{}】", sensorsFanSpeeds, senorsCpuVolTage, senorsCpuTemperature);

        // 内存信息
        GlobalMemory globalMemory = hardware.getMemory();

        long memoryTotal = globalMemory.getTotal();
        long memoryAvailable = globalMemory.getAvailable();
        long memoryPageSize = globalMemory.getPageSize();
        List<PhysicalMemory> memoryPhysicalMemory = globalMemory.getPhysicalMemory();
        VirtualMemory memoryVirtualMemory = globalMemory.getVirtualMemory();

        log.info("总内存数量：【{}】，可用内存数量：【{}】，内存页大小：【{}】，虚拟内存：【{}】，物理内存：【{}】",
                memoryTotal, memoryAvailable, memoryPageSize, memoryVirtualMemory, memoryPhysicalMemory);

        // CPU 线程信息
        CentralProcessor processor = hardware.getProcessor();
        log.info("CPU 线程数量:【{}】", processor.toString());

        // 显示器信息 型号、分辨率等
        List<Display> displays = hardware.getDisplays();
        Display display1 = hardware.getDisplays().get(0);

        // 获取磁盘信息 读写状态、分区信息等
        List<HWDiskStore> diskStore = hardware.getDiskStores();
        log.info("获取磁盘信息【{}】",diskStore.toString());

        // 获取网卡信息 详细信息，mac ip4/6地址，读写状态，中断/错误

        List<NetworkIF> networkIF = hardware.getNetworkIFs();
        log.info("网卡信息：【{}】", networkIF.toArray());

        // 电压状态
        List<PowerSource> powerSource = hardware.getPowerSources();
        log.info("电压状态：【{}】", powerSource.toArray());

        // 声卡信息
        List<SoundCard> soundCard = hardware.getSoundCards();
        log.info("声卡信息：【{}】", soundCard);

        // USB 信息
        List<UsbDevice> usbDevice = hardware.getUsbDevices(true);
        log.info("获取USB信息：【{}】", usbDevice);


    }
}
