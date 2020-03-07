#!/usr/bin/python
#VINCENZO CAVALLO

#Librerie API importate:
from mininet.net import Mininet
from mininet.node import Controller, RemoteController
from mininet.cli import CLI
from mininet.link import Intf
from mininet.log import setLogLevel, info
from mininet.link import Link, TCLink
import time

#Avvio tempo
info('Tempo iniziale')
start_time = time.time()
print("--- %s seconds ---" % (time.time() - start_time))
#Definisco la classe principale myNetwork
def myNetwork():
	net = Mininet(topo=None,build=False, link=TCLink)
#Aggiungo il Controller Remoto c0 
	info('*** Aggiungo controller\n')
	net.addController(name='c0',controller=RemoteController,ip='127.0.0.1',port=6633)
#Aggiungo gli switch
	info( '*** Aggiungo switch s1\n')
	s1 = net.addSwitch('s1')
        info( '*** Aggiungo switch s2\n')
	s2 = net.addSwitch('s2')
	info( '*** Aggiungo switch s3\n')
	s3 = net.addSwitch('s3')
	info( '*** Aggiungo switch s4\n')
	s4 = net.addSwitch('s4')
        info( '*** Aggiungo switch s5\n')
	s5 = net.addSwitch('s5')
	info( '*** Aggiungo switch s6\n')
	s6 = net.addSwitch('s6')
	info( '*** Aggiungo switch s7\n')
	s7 = net.addSwitch('s7')
#Aggiungo gli host
	info('*** Aggiungo 8 host\n')
	h1 = net.addHost('h1', ip='10.0.0.1')
	h2 = net.addHost('h2',ip='10.0.0.2')
	h3 = net.addHost('h3', ip='10.0.0.3')
	h4 = net.addHost('h4', ip='10.0.0.4')
	h5 = net.addHost('h5', ip='10.0.0.5')
	h6 = net.addHost('h6',ip='10.0.0.6')
	h7 = net.addHost('h7', ip='10.0.0.7')
	h8 = net.addHost('h8', ip='10.0.0.8')
	info('*** Aggiungo i collegamenti\n')
#Collegamenti tra gli host h1 h2 e lo switch s3
	net.addLink(h1, s3)
	net.addLink(h2, s3)
#Collegamenti tra gli host h3 h4 e lo switch s4
	net.addLink(h3, s4)
	net.addLink(h4, s4)
#Collegamenti tra gli host h1 h2 e lo switch s3
	net.addLink(h5, s6)
	net.addLink(h6, s6)
#Collegamenti tra gli host h3 h4 e lo switch s4
	net.addLink(h7, s7)
	net.addLink(h8, s7)
#Collegamenti tra gli switch
	net.addLink(s1, s2)
	net.addLink(s2, s3)
	net.addLink(s2, s4)
	net.addLink(s1, s5)
	net.addLink(s5, s6)
	net.addLink(s5, s7)
#Avvio rete
	info('*** Avvio rete\n')
	net.start()
	mid_time = time.time();
	print("--- %s seconds ---" % (mid_time - start_time))
	#info('*** Dumping host connections\n')
 	#dumpNodeConnections(net.hosts)
	info('*** Testing network connectivity\n')
	#net.pingAll()
        print h1.cmd('ping -c1 %s' % h2.IP())
	print h2.cmd('ping -c1 %s' % h3.IP())
	print h3.cmd('ping -c1 %s' % h4.IP())
	print h4.cmd('ping -c1 %s' % h5.IP())
	print h5.cmd('ping -c1 %s' % h6.IP())
	print h6.cmd('ping -c1 %s' % h7.IP())
	print h7.cmd('ping -c1 %s' % h8.IP())
	info('Tempo finale')
	end_time = time.time()
	print("--- %s seconds ---" % (end_time - start_time))
	net.stop()
#Definisco la main class
if __name__ == '__main__':
	setLogLevel('info')
	myNetwork()
