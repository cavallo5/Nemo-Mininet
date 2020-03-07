import it.unipr.netsec.ipstack.ip4.Ip4Address;
import it.unipr.netsec.ipstack.ip4.Ip4Prefix;
import it.unipr.netsec.nemo.ip.Ip4Host;
import it.unipr.netsec.nemo.ip.Ip4Router;
import it.unipr.netsec.nemo.ip.IpLink;
import it.unipr.netsec.nemo.routing.ShortestPathAlgorithm;
import it.unipr.netsec.nemo.routing.sdn.SdnRouting;


public class tree4 {

	public static void main(String[] args) {
		//Tempo iniziale
		double start_time = System.currentTimeMillis();
		System.out.println("Tempo iniziale " + (System.currentTimeMillis() - start_time) + " sec");
		long bit_rate=1000000; // 1Mb/s
		int n=31; // number of routers
		int c=1; // number of ping messages

		IpLink link1=new IpLink(bit_rate,new Ip4Prefix("10.1.0.0/16"));
		IpLink link2=new IpLink(bit_rate,new Ip4Prefix("10.2.0.0/16"));
		IpLink link3=new IpLink(bit_rate,new Ip4Prefix("10.3.0.0/16"));
		IpLink link4=new IpLink(bit_rate,new Ip4Prefix("10.4.0.0/16"));
		IpLink link5=new IpLink(bit_rate,new Ip4Prefix("10.5.0.0/16"));
		IpLink link6=new IpLink(bit_rate,new Ip4Prefix("10.6.0.0/16"));
		IpLink link7=new IpLink(bit_rate,new Ip4Prefix("10.7.0.0/16"));
		IpLink link8=new IpLink(bit_rate,new Ip4Prefix("10.8.0.0/16"));
		IpLink link9=new IpLink(bit_rate,new Ip4Prefix("10.9.0.0/16"));
		IpLink link10=new IpLink(bit_rate,new Ip4Prefix("10.10.0.0/16"));
		IpLink link11=new IpLink(bit_rate,new Ip4Prefix("10.11.0.0/16"));
		IpLink link12=new IpLink(bit_rate,new Ip4Prefix("10.12.0.0/16"));
		IpLink link13=new IpLink(bit_rate,new Ip4Prefix("10.13.0.0/16"));
		IpLink link14=new IpLink(bit_rate,new Ip4Prefix("10.14.0.0/16"));
		IpLink link15=new IpLink(bit_rate,new Ip4Prefix("10.15.0.0/16"));
		IpLink link16=new IpLink(bit_rate,new Ip4Prefix("10.16.0.0/16"));
		IpLink link17=new IpLink(bit_rate,new Ip4Prefix("10.17.0.0/16"));
		IpLink link18=new IpLink(bit_rate,new Ip4Prefix("10.18.0.0/16"));
		IpLink link19=new IpLink(bit_rate,new Ip4Prefix("10.19.0.0/16"));
		IpLink link20=new IpLink(bit_rate,new Ip4Prefix("10.20.0.0/16"));
		IpLink link21=new IpLink(bit_rate,new Ip4Prefix("10.21.0.0/16"));
		IpLink link22=new IpLink(bit_rate,new Ip4Prefix("10.22.0.0/16"));
		IpLink link23=new IpLink(bit_rate,new Ip4Prefix("10.23.0.0/16"));
		IpLink link24=new IpLink(bit_rate,new Ip4Prefix("10.24.0.0/16"));
		IpLink link25=new IpLink(bit_rate,new Ip4Prefix("10.25.0.0/16"));
		IpLink link26=new IpLink(bit_rate,new Ip4Prefix("10.26.0.0/16"));
		IpLink link27=new IpLink(bit_rate,new Ip4Prefix("10.27.0.0/16"));
		IpLink link28=new IpLink(bit_rate,new Ip4Prefix("10.28.0.0/16"));
		IpLink link29=new IpLink(bit_rate,new Ip4Prefix("10.29.0.0/16"));
		IpLink link30=new IpLink(bit_rate,new Ip4Prefix("10.30.0.0/16"));
		IpLink link31=new IpLink(bit_rate,new Ip4Prefix("10.31.0.0/16"));
		IpLink link32=new IpLink(bit_rate,new Ip4Prefix("10.32.0.0/16"));
		IpLink link33=new IpLink(bit_rate,new Ip4Prefix("10.33.0.0/16"));
		IpLink link34=new IpLink(bit_rate,new Ip4Prefix("10.34.0.0/16"));
		Ip4Router r1=new Ip4Router(new IpLink[]{link1,link19});
		Ip4Router r2=new Ip4Router(new IpLink[]{link1,link2});
		Ip4Router r3=new Ip4Router(new IpLink[]{link2,link3});
		Ip4Router r4=new Ip4Router(new IpLink[]{link3,link4});
		Ip4Router r5=new Ip4Router(new IpLink[]{link4,link5});
		Ip4Router r6=new Ip4Router(new IpLink[]{link4,link6});
		Ip4Router r7=new Ip4Router(new IpLink[]{link3,link7});
		Ip4Router r8=new Ip4Router(new IpLink[]{link7,link8});
		Ip4Router r9=new Ip4Router(new IpLink[]{link7,link9});
		Ip4Router r10=new Ip4Router(new IpLink[]{link2,link10});
		Ip4Router r11=new Ip4Router(new IpLink[]{link10,link11});
		Ip4Router r12=new Ip4Router(new IpLink[]{link10,link16});
		Ip4Router r13=new Ip4Router(new IpLink[]{link11,link14});
		Ip4Router r14=new Ip4Router(new IpLink[]{link11,link15});
		Ip4Router r15=new Ip4Router(new IpLink[]{link16,link17});
		Ip4Router r16=new Ip4Router(new IpLink[]{link16,link18});
		Ip4Router r17=new Ip4Router(new IpLink[]{link19,link20});
		Ip4Router r18=new Ip4Router(new IpLink[]{link20,link21});
		Ip4Router r19=new Ip4Router(new IpLink[]{link21,link22});
		Ip4Router r20=new Ip4Router(new IpLink[]{link22,link23});
		Ip4Router r21=new Ip4Router(new IpLink[]{link21,link24});
		Ip4Router r22=new Ip4Router(new IpLink[]{link21,link25});
		Ip4Router r23=new Ip4Router(new IpLink[]{link25,link26});
		Ip4Router r24=new Ip4Router(new IpLink[]{link25,link27});
		Ip4Router r25=new Ip4Router(new IpLink[]{link20,link28});
		Ip4Router r26=new Ip4Router(new IpLink[]{link28,link29});
		Ip4Router r27=new Ip4Router(new IpLink[]{link29,link30});
		Ip4Router r28=new Ip4Router(new IpLink[]{link29,link31});
		Ip4Router r29=new Ip4Router(new IpLink[]{link28,link32});
		Ip4Router r30=new Ip4Router(new IpLink[]{link32,link33});
		Ip4Router r31=new Ip4Router(new IpLink[]{link32,link34});

		//Creazione Router SDN 
		SdnRouting routing=new SdnRouting(ShortestPathAlgorithm.DIJKSTRA);
		Ip4Router[] routers={r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31};	
		for (int i=0; i<n; i++) {
			routers[i].setDynamicRouting(routing);
		}	

		Ip4Host h1=new Ip4Host(link5);		
		Ip4Host h2=new Ip4Host(link5);
		Ip4Host h3=new Ip4Host(link6);		
		Ip4Host h4=new Ip4Host(link6);
		Ip4Host h5=new Ip4Host(link8);		
		Ip4Host h6=new Ip4Host(link8);
		Ip4Host h7=new Ip4Host(link9);		
		Ip4Host h8=new Ip4Host(link9);
		Ip4Host h9=new Ip4Host(link14);		
		Ip4Host h10=new Ip4Host(link14);
		Ip4Host h11=new Ip4Host(link15);		
		Ip4Host h12=new Ip4Host(link15);
		Ip4Host h13=new Ip4Host(link17);		
		Ip4Host h14=new Ip4Host(link17);
		Ip4Host h15=new Ip4Host(link18);		
		Ip4Host h16=new Ip4Host(link18);
		Ip4Host h17=new Ip4Host(link23);		
		Ip4Host h18=new Ip4Host(link23);
		Ip4Host h19=new Ip4Host(link24);		
		Ip4Host h20=new Ip4Host(link24);
		Ip4Host h21=new Ip4Host(link26);		
		Ip4Host h22=new Ip4Host(link26);
		Ip4Host h23=new Ip4Host(link27);		
		Ip4Host h24=new Ip4Host(link27);
		Ip4Host h25=new Ip4Host(link30);		
		Ip4Host h26=new Ip4Host(link30);
		Ip4Host h27=new Ip4Host(link31);		
		Ip4Host h28=new Ip4Host(link31);
		Ip4Host h29=new Ip4Host(link33);		
		Ip4Host h30=new Ip4Host(link33);
		Ip4Host h31=new Ip4Host(link34);		
		Ip4Host h32=new Ip4Host(link34);


		//Tempo creazione rete
		double mid_time = System.currentTimeMillis();
		double time1=(mid_time-start_time)/1000;
		System.out.println("Tempo creazione rete " +time1+ " sec");

 		//Testing network connectivity
 		routing.updateAllNodes(); //Instaurazione regole nelle tabelle di routing
		h1.ping((Ip4Address)h31.getAddress(),c,System.out);
		h2.ping((Ip4Address)h3.getAddress(),c,System.out);
		h3.ping((Ip4Address)h4.getAddress(),c,System.out);
		h4.ping((Ip4Address)h5.getAddress(),c,System.out);
		h6.ping((Ip4Address)h7.getAddress(),c,System.out);
		h7.ping((Ip4Address)h8.getAddress(),c,System.out);
		h9.ping((Ip4Address)h10.getAddress(),c,System.out);
		h11.ping((Ip4Address)h12.getAddress(),c,System.out);
		h13.ping((Ip4Address)h14.getAddress(),c,System.out);
		h15.ping((Ip4Address)h16.getAddress(),c,System.out);
		h17.ping((Ip4Address)h18.getAddress(),c,System.out);
		h19.ping((Ip4Address)h20.getAddress(),c,System.out);
		h21.ping((Ip4Address)h22.getAddress(),c,System.out);
		h23.ping((Ip4Address)h24.getAddress(),c,System.out);
		h25.ping((Ip4Address)h26.getAddress(),c,System.out);
		h27.ping((Ip4Address)h28.getAddress(),c,System.out);
		h29.ping((Ip4Address)h30.getAddress(),c,System.out);
		h31.ping((Ip4Address)h32.getAddress(),c,System.out);
		
		double end_time = System.currentTimeMillis();
		double time2=(end_time-start_time)/1000;
		System.out.println("Tempo network connectivity " +time2 + " sec");

	}
}