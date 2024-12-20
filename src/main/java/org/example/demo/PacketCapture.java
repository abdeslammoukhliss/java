package org.example.demo;

import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

public class PacketCapture {
    public static void main(String[] args) throws PcapNativeException, NotOpenException, InterruptedException {
        PcapNetworkInterface nif = Pcaps.findAllDevs().get(0); // Get the first network interface
        System.out.println("Using interface: " + nif.getName());

        int snapshotLength = 65536; // Capture packet size
        int timeout = 10; // Timeout in milliseconds
        PcapHandle handle = nif.openLive(snapshotLength, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, timeout);

        System.out.println("Listening for packets...");
        handle.loop(10, new PacketListener() {
            @Override
            public void gotPacket(Packet packet) {
                System.out.println(packet.getRawData());
            }
        });

        handle.close();
    }
}
