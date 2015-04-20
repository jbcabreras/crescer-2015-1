
--1
select 
left( Nome, charindex(' ', Nome + ' ' ) ) as primeiro_nome
from Associado

--2
select nome, FLOOR(DATEDIFF(DAY, DataNascimento, GETDATE()) / 365.25)
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
select top 1 cargo
from empregado

--5
select top 1 nome 
from associado
order by len(nome) desc

--6
select nome, DATEADD(YEAR, 50, DataNascimento) 
from associado





