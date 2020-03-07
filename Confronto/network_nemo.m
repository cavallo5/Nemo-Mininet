clc;
clear all;
close all;

nodi=[7 15 31 63];
tempicreazione=[0.052 0.054 0.057 0.061]
tempiconnettivita=[0.069 0.086 0.113 0.173]

subplot(2,1,1)
plot(nodi, tempicreazione,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('Numero di nodi')
ylabel('Tempo creazione rete')
grid on

subplot(2,1,2)
plot(nodi, tempiconnettivita,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('Numero di nodi')
ylabel('Tempo connettività rete')
grid on