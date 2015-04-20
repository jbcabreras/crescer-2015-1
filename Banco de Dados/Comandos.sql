select NomeEmpregado, DataAdmissao
from empregado
order by DataAdmissao

select NomeEmpregado, (salario * 12) as salario_anual
from empregado
where cargo = 'atendente' or (salario * 12) < 18500

select idcidade
from cidade
where nome = 'uberlândia'

select idcidade, nome
from cidade
where uf = 'rs'