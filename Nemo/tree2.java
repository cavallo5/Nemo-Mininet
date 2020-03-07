import it.unipr.netsec.ipstack.ip4.Ip4Address;
import it.unipr.netsec.ipstack.ip4.Ip4Prefix;
import it.unipr.netsec.nemo.ip.Ip4Host;
import it.unipr.netsec.nemo.ip.Ip4Router;
import it.unipr.netsec.nemo.ip.IpLink;
import it.unipr.netsec.nemo.routing.ShortestPathAlgorithm;
import it.unipr.netsec.nemo.routing.sdn.SdnRouting;


public class tree2 {

	public static void main(String[] args) {
		//Tempo iniziale
		double start_time = System.currentTimeMillis();
		System.out.println("Tempo iniziale " + (System.currentTimeMillis() - start_time) + " sec");
		long bit_rate=1000000; // 1Mb/s
		int n=7; // number of routers
		int c=1; // number of ping messages

		IpLink link1=new IpLink(bit_rate,new Ip4Prefix("10.1.0.0/16"));
		IpLink link2=new IpLink(bit_rate,new Ip4Prefix("10.2.0.0/16"));
		IpLink link3=new IpLink(bit_rate,new Ip4Prefix("10.3.0.0/16"));
		IpLink link4=new IpLink(bit_rate,new Ip4Prefix("10.4.0.0/16"));
		IpLink link5=new IpLink(bit_rate,new Ip4Prefix("10.5.0.0/16"));
		IpLink link6=new IpLink(bit_rate,new Ip4Prefix("10.6.0.0/16"));
		IpLink link7=new IpLink(bit_rate,new Ip4Prefix("10.7.0.0/16"));
		IpLink link8=new IpLink(bit_rate,new Ip4Prefix("10.8.0.0/16"));
		Ip4Router r1=new Ip4Router(new IpLink[]{link1,link5});
		Ip4Router r2=new Ip4Router(new IpLink[]{link1,link2});
		Ip4Router r3=new Ip4Router(new IpLink[]{link2,link3});
		Ip4Router r4=new Ip4Router(new IpLink[]{link2,link4});
		Ip4Router r5=new Ip4Router(new IpLink[]{link5,link6});
		Ip4Router r6=new Ip4Router(new IpLink[]{link6,link7});
		Ip4Router r7=new Ip4Router(new IpLink[]{link6,link8});
		//Creazione Router SDN 
		SdnRouting routing=new SdnRouting(ShortestPathAlgorithm.DIJKSTRA);
		Ip4Router[] routers={r1,r2,r3,r4,r5,r6,r7};	
		for (int i=0; i<n; i++) {
			routers[i].setDynamicRouting(routing);
		}	

		Ip4Host h1=new Ip4Host(link3);		
		Ip4Host h2=new Ip4Host(link3);
		Ip4Host h3=new Ip4Host(link4);		
		Ip4Host h4=new Ip4Host(link4);
		Ip4Host h5=new Ip4Host(link7);		
		Ip4Host h6=new Ip4Host(link7);
		Ip4Host h7=new Ip4Host(link8);		
		Ip4Host h8=new Ip4Host(link8);

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
		double end_time = System.currentTimeMillis();
		double time2=(end_time-start_time)/1000;
		System.out.println("Tempo network connectivity " +time2 + " sec");

	}
}