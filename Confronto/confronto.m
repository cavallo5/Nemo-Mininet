clc;
clear all;
close all;

nodi=[7 15 31 63];
tempototalemininet=[0.63 1.8 4.51 10.24]
tempototalenemo=[0.121 0.14 0.17 0.234]

plot(nodi, tempototalemininet,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('Numero di nodi')
ylabel('Tempo totale mininet')
hold on
plot(nodi, tempototalenemo,'- k o' , 'LineWidth' , 3 , 'MarkerSize', 6,'MarkerEdgeColor','red','MarkerFaceColor','green')
xlabel('Numero di nodi')
ylabel('Tempo totale')
grid on