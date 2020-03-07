import it.unipr.netsec.ipstack.ip6.Ip6Address;
import it.unipr.netsec.ipstack.ip6.Ip6Prefix;
import it.unipr.netsec.nemo.ip.Ip6Host;
import it.unipr.netsec.nemo.ip.Ip6Router;
import it.unipr.netsec.nemo.ip.IpLink;
import it.unipr.netsec.nemo.routing.ShortestPathAlgorithm;
import it.unipr.netsec.nemo.routing.sdn.SdnRouting;


public class Example1 {

	public static void main(String[] args) {
		//Tempo iniziale
		double start_time = System.currentTimeMillis();
		System.out.println("Tempo iniziale " + (System.currentTimeMillis() - start_time) + " sec");
		long bit_rate=1000000; // 1Mb/s
		int n=1; // number of routers
		int c=1; // number of ping messages

		IpLink[] links=new IpLink[n+1];
		for (int i=0; i<n+1; i++) links[i]=new IpLink(bit_rate,new Ip6Prefix("fc00:"+(i+1)+"::/64"));
		
		//Creazione Router SDN 
		SdnRouting routing=new SdnRouting(ShortestPathAlgorithm.DIJKSTRA);
		Ip6Router[] routers=new Ip6Router[n];	
		for (int i=0; i<n; i++) {
			routers[i]=new Ip6Router(new IpLink[]{links[i],links[i+1]});
			routers[i].setDynamicRouting(routing);
		}	

		Ip6Host h1=new Ip6Host(links[0]);		
		Ip6Host h2=new Ip6Host(links[n]);

		//Tempo creazione rete
		double mid_time = System.currentTimeMillis();
		double time1=(mid_time-start_time)/1000;
		System.out.println("Tempo creazione rete " +time1+ " sec");

 		//Testing network connectivity
 		routing.updateAllNodes(); //Instaurazione regole nelle tabelle di routing
		h1.ping((Ip6Address)h2.getAddress(),c,System.out);
		h2.ping((Ip6Address)h1.getAddress(),c,System.out);

		double end_time = System.currentTimeMillis();
		double time2=(end_time-start_time)/1000;
		System.out.println("Tempo network connectivity " +time2 + " sec");

	}
}