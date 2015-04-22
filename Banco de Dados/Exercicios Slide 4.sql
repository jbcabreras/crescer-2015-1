
--1
select 
left( Nome, charindex(' ', Nome + ' ' ) ) as primeiro_nome
from Associado

--2
select nome, DATEDIFF(year, DataNascimento, GETDATE())
from Associado

--3
select NomeEmpregado,
	   DateDiff(Month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as MesesTrabalho
from empregado
where DataAdmissao between convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103)

--select cargo, count(NomeEmpregado)
--from empregado
--group by cargo 

--4
select top 1 WITH TIES
	cargo, count(1) as Total_Emp
from empregado
group by cargo
order by Total_Emp desc


--5
select top 1
	nome 
from associado
order by len(nome) desc

--6
select nome, DATEADD(YEAR, 50, DataNascimento),
	   datename(dw, dateadd(year, 50, DataNascimento))
from associado

--7
select count(nome) as qtd,
	   uf
from cidade
group by uf
order by qtd

--8
select nome, uf
from cidade
group by nome, uf 
having count(*) > 1

--9
select max(idassociado) + 1 as prox_id
from Associado

--10
begin transaction
truncate table cidadeAux

insert into CidadeAux 
values (int identity, (select DISTINCT NOME, UF from cidade))

select * from cidadeAux

--11
