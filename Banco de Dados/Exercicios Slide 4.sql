
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
select count(1) as qtd,
	   uf
from cidade
group by uf
order by qtd

--8
select nome, uf
from cidade
group by nome, uf 
having count(1) > 1

--9
select (isnull(max(idassociado), 0) + 1) as prox_id
from Associado

--10
begin transaction
truncate table cidadeAux

insert into CidadeAux (idcidade, nome, uf)
	(select min(idcidade), NOME, UF 
	    from cidade
		group by nome, uf)

--select * from cidadeAux

--11)Altere todas cidades duplicadas (nome e uf iguais), acrescente no ínicio do nome um asterisco (*).

begin transaction
update cidade set nome = '*' + nome
where nome in (select nome
			  from cidade
			  group by nome, uf 
              having count(1) > 1)

select * from cidade

rollback

--12)Faça uma consulta que liste o nome do Associado e a descrição da coluna Sexo, informando: Masculino ou Feminino.

select nome, Replace(Replace(sexo, upper('m'), 'Masculino'), upper('f'), 'Feminino')
from Associado

select *from Associado

--13)Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda,
--considerando a tabela abaixo: Até R$ 1.164,00 = 0%, De R$ 1.164,00 a R$ 2.326,00 = 15%, Acima de R$ 2.326,00 = 27,5%.

select nomeEmpregado, salario,
	case
		when salario > 2326 then '27,5%'
		when salario >= 1164 then '15%'
		when salario < 1164 then '0%'
	end 
from empregado


--14)Elimine as cidades duplicadas (mantendo 1 registro para cada).

begin transaction
delete from cidade
where idcidade in (select min(idcidade) 
				   from cidade
				   group by nome, uf
				   having count(1) > 1)


--15)Adicione uma regra que impeça exista mais de uma cidade com o mesmo nome em um estado.

begin transaction
alter table cidade add constraint uk_nome_uf unique(nome, uf)
