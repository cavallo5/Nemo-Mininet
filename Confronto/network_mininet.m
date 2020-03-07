clc;
clear all;
close all;

nodi=[31 63 127 255 511 1023 2047];
tempi_creazione_rete=[1.58 3.06 6.58 14.71 26.21 87.77 314.44]
CPU_controller_s=[12.3 23.9 46.5 47.2 48.4 48.4 48.4]
CPU_setup=[10.4 21.6 48.8 46.5 47.7 48.2 49.2]
MEM_setup=[0.9 1.2 1.4 1.5 2 3.1 6.4]
ping_1=[85.5 86.8 210 250 1410 3548 inf]
ping_2=[0.07 0.09 0.16 0.18 0.2 0.24 inf]
CPU_ping=[0.7 2 4 5.6 8.9 21.1 46]
MEM_ping=[1 1.4 1.5 1.5 2 3.2 7]

subplot(4,2,1)
plot(nodi, tempi_creazione_rete,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('TEMPO CREAZIONE RETE')
grid on

subplot(4,2,2)
plot(nodi, CPU_controller_s ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%CPU (CONTROLLER)')
grid on

subplot(4,2,3)
plot(nodi, CPU_setup ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%CPU SETUP')
grid on

subplot(4,2,4)
plot(nodi, MEM_setup ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%MEM SETUP')
grid on

subplot(4,2,5)
plot(nodi, ping_1 ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%PRIMO PING COMPLETATO')
grid on

subplot(4,2,6)
plot(nodi, ping_2 ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%MEDIA PING SUCCESSIVI')
grid on

subplot(4,2,7)
plot(nodi, CPU_ping ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%CPU PING')
grid on

subplot(4,2,8)
plot(nodi, MEM_ping ,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('NUMERO NODI')
ylabel('%MEM PING')
grid on
