import it.unipr.netsec.ipstack.ip4.Ip4Address;
import it.unipr.netsec.ipstack.ip4.Ip4Prefix;
import it.unipr.netsec.nemo.ip.Ip4Host;
import it.unipr.netsec.nemo.ip.Ip4Router;
import it.unipr.netsec.nemo.ip.IpLink;
import it.unipr.netsec.nemo.routing.ShortestPathAlgorithm;
import it.unipr.netsec.nemo.routing.sdn.SdnRouting;


public class tree3 {

	public static void main(String[] args) {
		//Tempo iniziale
		double start_time = System.currentTimeMillis();
		System.out.println("Tempo iniziale " + (System.currentTimeMillis() - start_time) + " sec");
		long bit_rate=1000000; // 1Mb/s
		int n=15; // number of routers
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
		Ip4Router r1=new Ip4Router(new IpLink[]{link1,link9});
		Ip4Router r2=new Ip4Router(new IpLink[]{link1,link2});
		Ip4Router r3=new Ip4Router(new IpLink[]{link2,link3});
		Ip4Router r4=new Ip4Router(new IpLink[]{link3,link4});
		Ip4Router r5=new Ip4Router(new IpLink[]{link3,link5});
		Ip4Router r6=new Ip4Router(new IpLink[]{link2,link6});
		Ip4Router r7=new Ip4Router(new IpLink[]{link6,link7});
		Ip4Router r8=new Ip4Router(new IpLink[]{link6,link8});
		Ip4Router r9=new Ip4Router(new IpLink[]{link9,link10});
		Ip4Router r10=new Ip4Router(new IpLink[]{link10,link11});
		Ip4Router r11=new Ip4Router(new IpLink[]{link11,link12});
		Ip4Router r12=new Ip4Router(new IpLink[]{link11,link13});
		Ip4Router r13=new Ip4Router(new IpLink[]{link10,link14});
		Ip4Router r14=new Ip4Router(new IpLink[]{link14,link15});
		Ip4Router r15=new Ip4Router(new IpLink[]{link14,link16});
		//Creazione Router SDN 
		SdnRouting routing=new SdnRouting(ShortestPathAlgorithm.DIJKSTRA);
		Ip4Router[] routers={r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15};	
		for (int i=0; i<n; i++) {
			routers[i].setDynamicRouting(routing);
		}	

		Ip4Host h1=new Ip4Host(link4);		
		Ip4Host h2=new Ip4Host(link4);
		Ip4Host h3=new Ip4Host(link5);		
		Ip4Host h4=new Ip4Host(link5);
		Ip4Host h5=new Ip4Host(link7);		
		Ip4Host h6=new Ip4Host(link7);
		Ip4Host h7=new Ip4Host(link8);		
		Ip4Host h8=new Ip4Host(link8);
		Ip4Host h9=new Ip4Host(link12);		
		Ip4Host h10=new Ip4Host(link12);
		Ip4Host h11=new Ip4Host(link13);		
		Ip4Host h12=new Ip4Host(link13);
		Ip4Host h13=new Ip4Host(link15);		
		Ip4Host h14=new Ip4Host(link15);
		Ip4Host h15=new Ip4Host(link16);		
		Ip4Host h16=new Ip4Host(link16);


		//Tempo creazione rete
		double mid_time = System.currentTimeMillis();
		double time1=(mid_time-start_time)/1000;
		System.out.println("Tempo creazione rete " +time1+ " sec");

 		//Testing network connectivity
 		routing.updateAllNodes(); //Instaurazione regole nelle tabelle di routing
		h1.ping((Ip4Address)h2.getAddress(),c,System.out);
		h2.ping((Ip4Address)h3.getAddress(),c,System.out);
		h3.ping((Ip4Address)h4.getAddress(),c,System.out);
		h4.ping((Ip4Address)h5.getAddress(),c,System.out);
		h6.ping((Ip4Address)h7.getAddress(),c,System.out);
		h7.ping((Ip4Address)h8.getAddress(),c,System.out);
		h9.ping((Ip4Address)h10.getAddress(),c,System.out);
		h11.ping((Ip4Address)h12.getAddress(),c,System.out);
		h13.ping((Ip4Address)h14.getAddress(),c,System.out);
		h15.ping((Ip4Address)h16.getAddress(),c,System.out);
		
		double end_time = System.currentTimeMillis();
		double time2=(end_time-start_time)/1000;
		System.out.println("Tempo network connectivity " +time2 + " sec");

	}
}