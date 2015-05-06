update associado
set idcidade = 1
where idassociado = 1

update associado
set idcidade = 33
where idassociado = 3

--1)Selecione o nome do empregado e nome do departamento que cada um est� associado.

select nomeEmpregado, nomeDepartamento
from empregado e
	left join departamento d on e.iddepartamento = d.IDDepartamento

--2)Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.

select a.nome, c.nome 
from Associado a
	left join Cidade c on a.IDCidade = c.IDCidade

--3)Lista os estados (UF) e total de cidades que n�o possuem associados relacionados 
--(dica: pode ser utilizado count + group by + exists).

select c.uf, count(c.nome)
from Cidade c
	 left join Associado a on c.IDCidade = a.IDCidade
where a.Nome is null
group by c.uf
order by c.uf

--4)Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade
-- � da regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), sen�o imprimir nulo.

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

--6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados que o departamento 
--fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%

begin transaction

select * into EmpregadoAux
from Empregado

--select * from EmpregadoAux order by salario desc

update EmpregadoAux set Salario = Salario * 1.145
where IDDepartamento in (select IDDepartamento from Departamento where Localizacao = 'SAO PAULO') 

commit

--7)Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios
-- de todos os empregados.

select (sum(ea.salario) - sum(e.salario)) as diferenca
from Empregado e
	 join EmpregadoAux ea on e.IDEmpregado = ea.IDEmpregado

--8)Liste o departamento que possui o empregado de maior sal�rio.

select NomeDepartamento
from Departamento d
where d.iddepartamento in (select top 1 IDDepartamento 
						   from empregadoAux e
						   where IDDepartamento is not null
						   group by IDDepartamento 
						   order by max(salario) desc)
						   
						  

--select * from empregado order by salario desc

--select * from Departamento

--9)Fa�a uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os
--empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.

select a.nome, c.nome 
from Associado a
	join cidade c on a.IDCidade = c.IDCidade
union 
select e.NomeEmpregado, d.localizacao
from empregado e
	join Departamento d on e.IDDepartamento = d.IDDepartamento


--10)Lista as cidades que tenham associado relacionado.

select c.nome
from cidade c
where c.idcidade in (select IDCidade from Associado where IDCidade is not null)

