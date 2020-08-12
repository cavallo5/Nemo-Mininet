#!/usr/bin/python

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
        info( '*** Aggiungo switch s8\n')
  	s8 = net.addSwitch('s8')
        info( '*** Aggiungo switch s9\n')
 	s9 = net.addSwitch('s9')
	info( '*** Aggiungo switch s10\n')
	s10 = net.addSwitch('s10')
	info( '*** Aggiungo switch s11\n')
	s11 = net.addSwitch('s11')
        info( '*** Aggiungo switch s12\n')
	s12 = net.addSwitch('s12')
	info( '*** Aggiungo switch s13\n')
	s13 = net.addSwitch('s13')
	info( '*** Aggiungo switch s14\n')
	s14 = net.addSwitch('s14')
	info( '*** Aggiungo switch s15\n')
	s15 = net.addSwitch('s15')
#Aggiungo gli host
	info('*** Aggiungo gli host\n')
	h1 = net.addHost('h1', ip='10.0.0.1')
	h2 = net.addHost('h2',ip='10.0.0.2')
	h3 = net.addHost('h3', ip='10.0.0.3')
	h4 = net.addHost('h4', ip='10.0.0.4')
	h5 = net.addHost('h5', ip='10.0.0.5')
	h6 = net.addHost('h6',ip='10.0.0.6')
	h7 = net.addHost('h7', ip='10.0.0.7')
	h8 = net.addHost('h8', ip='10.0.0.8')
	h9 = net.addHost('h9', ip='10.0.0.9')
	h10 = net.addHost('h10',ip='10.0.0.10')
	h11 = net.addHost('h11', ip='10.0.0.11')
	h12 = net.addHost('h12', ip='10.0.0.12')
	h13 = net.addHost('h13', ip='10.0.0.13')
	h14 = net.addHost('h14',ip='10.0.0.14')
	h15 = net.addHost('h15', ip='10.0.0.15')
	h16 = net.addHost('h16', ip='10.0.0.16')
	info('*** Aggiungo i collegamenti\n')
#Collegamenti tra gli host h1 h2 e lo switch s4
	net.addLink(h1, s4)
	net.addLink(h2, s4)
#Collegamenti tra gli host h3 h4 e lo switch s5
	net.addLink(h3, s5)
	net.addLink(h4, s5)
#Collegamenti tra gli host h5 h6 e lo switch s7
	net.addLink(h5, s7)
	net.addLink(h6, s7)
#Collegamenti tra gli host h7 h8 e lo switch s8
	net.addLink(h7, s8)
	net.addLink(h8, s8)
#Collegamenti tra gli host h9 h10 e lo switch s11
	net.addLink(h9, s11)
	net.addLink(h10, s11)
#Collegamenti tra gli host h11 h12 e lo switch s12
	net.addLink(h11, s12)
	net.addLink(h12, s12)
#Collegamenti tra gli host h13 h14 e lo switch s14
	net.addLink(h13, s14)
	net.addLink(h14, s14)
#Collegamenti tra gli host h15 h16 e lo switch s15
	net.addLink(h15, s15)
	net.addLink(h16, s15)
#Collegamenti tra gli switch
	net.addLink(s1, s2)
	net.addLink(s1, s9)
	net.addLink(s2, s3)
	net.addLink(s2, s6)
	net.addLink(s3, s4)
	net.addLink(s3, s5)
	net.addLink(s6, s7)
	net.addLink(s6, s8)
	net.addLink(s9, s10)
	net.addLink(s9, s13)
	net.addLink(s10, s11)
	net.addLink(s10, s12)
	net.addLink(s13, s14)
	net.addLink(s13, s15)
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
	print h8.cmd('ping -c1 %s' % h9.IP())
	print h9.cmd('ping -c1 %s' % h10.IP())
	print h10.cmd('ping -c1 %s' % h11.IP())
	print h11.cmd('ping -c1 %s' % h12.IP())
	print h12.cmd('ping -c1 %s' % h13.IP())
	print h13.cmd('ping -c1 %s' % h14.IP())
	print h14.cmd('ping -c1 %s' % h15.IP())
	print h15.cmd('ping -c1 %s' % h16.IP())
	
	info('Tempo finale')
	end_time = time.time()
	print("--- %s seconds ---" % (end_time - start_time))
	net.stop()
#Definisco la main class
if __name__ == '__main__':
	setLogLevel('info')
	myNetwork()
