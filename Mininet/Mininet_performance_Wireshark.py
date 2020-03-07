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

#Definisco la classe principale myNetwork
def myNetwork():
	net = Mininet(topo=None,build=False, link=TCLink)
#Aggiungo il Controller Remoto c0 
	info('*** Aggiungo controller\n')
	net.addController(name='c0',controller=RemoteController,ip='127.0.0.1',port=6633)
#Aggiungo uno switch s1
	info( '*** Aggiungo 1 switch\n')
	s1 = net.addSwitch('s1')
#Aggiungo 3 host h1 h2 h3
	info('*** Aggiungo 4 host\n')
	h1 = net.addHost('h1', ip='10.0.0.1')
	h2 = net.addHost('h2',ip='10.0.0.2')
	h3 = net.addHost('h3', ip='10.0.0.3')
	info('*** Aggiungo i collegamenti\n')
#Collegamenti tra gli host h1 h2 e h3 e lo switch s1
	net.addLink(h1, s1)
	net.addLink(h2, s1)
	net.addLink(h3, s1)
#Avvio rete
	info('*** Avvio rete\n')
	net.start()
	CLI(net)
	net.stop()
#Definisco la main class
if __name__ == '__main__':
	setLogLevel('info')
	myNetwork()