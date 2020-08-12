#!/usr/bin/python

#Librerie API importate:
from mininet.net import Mininet
from mininet.node import Controller, RemoteController
from mininet.cli import CLI
from mininet.link import Intf
from mininet.log import setLogLevel, info
from mininet.link import Link, TCLink
#from mininet.util import irange, dumpNodeConnections
import time
from mininet.topolib import TreeNet

if __name__ == '__main__':
	#Avvio tempo
	info('Tempo iniziale')
	start_time = time.time()
	print("--- %s seconds ---" % (time.time() - start_time))
        setLogLevel( 'info' )
        #Creazione rete
        net = TreeNet( depth=4, fanout=2, controller=RemoteController, link=TCLink)
	#Avvio rete
	info('*** Avvio rete\n')
	net.start()
	mid_time = time.time();
	print("--- %s seconds ---" % (mid_time - start_time))
	info('*** Testing network connectivity\n')
 	#time.sleep(10)
	#Verifica %CPU e %MEM tramite comando TOP
        CLI( net )
	info('*** Stopping network\n')
        net.stop()
