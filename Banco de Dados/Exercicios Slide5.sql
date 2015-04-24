update associado
set idcidade = 1
where idassociado = 1

update associado
set idcidade = 33
where idassociado = 3

--1)Selecione o nome do empregado e nome do departamento que cada um está associado.

select nomeEmpregado, nomeDepartamento
from empregado e
	left join departamento d on e.iddepartamento = d.IDDepartamento

--2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.

select a.nome, c.nome 
from Associado a
	left join Cidade c on a.IDCidade = c.IDCidade

--3)Lista os estados (UF) e total de cidades que não possuem associados relacionados 
--(dica: pode ser utilizado count + group by + exists).

select c.uf, count(c.nome)
from Cidade c
	 left join Associado a on c.IDCidade = a.IDCidade
where a.Nome is null
group by c.uf
order by c.uf

--4)Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade
-- é da região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.

select a.nome, c.nome, 
	   case 
		 when c.uf in ('RS','SC','PR') then '***'
		 else 'nulo'
	   end as Regiao_Sul
from associado a
	left join cidade c on a.IDCidade = c.IDCidade

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.

select e.nomeEmpregado as Empregado, g.nomeEmpregado as Gerente, d.nomeDepartamento as Departamento
from empregado e
	left join empregado g on e.IDEmpregado = g.IDGerente
	left join departamento d on e.IDDepartamento = d.IDDepartamento

--6)Faça uma cópia da tabela Empregado e altere o salário de todos os empregados que o departamento 
--fique na localidade de SAO PAULO, faça um reajuste de 14,5%

select into EmpregadoAux
from 

--7)Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários
-- de todos os empregados.
--8)Liste o departamento que possui o empregado de maior salário.