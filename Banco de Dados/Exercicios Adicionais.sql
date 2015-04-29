-- 1) Identifique e liste quantos valores diferentes est�o definidos para a coluna Situacao da tabela Produto 
--(somente os distintos valores).

select distinct situacao from produto


-- 2) Liste todos os clientes que tenham o LTDA no nome ou razao social.

select nome, razaoSocial
from cliente
where nome like '%LTDA%' or razaoSocial like '%LTDA%'

-- 3) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--Nome: Galocha Maragato
--Pre�o de custo: 35.67
--Pre�o de venda: 77.95
--Situa��o: A

insert into Produto(Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
values ('Galocha Maragato', convert(datetime, '27/04/2015', 103), 35.67, 77.95, 'A')


--4) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, 
--pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente dever� ser listado.

select pr.nome
from produto pr	
where not exists (select 1 from PedidoItem pdi where pdi.IDProduto = pr.IDProduto)

--5) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), 
--liste tamb�m qual o Estado possu� o menor n�mero de clientes.
--Dica: pode (n�o � obrigat�rio) ser utilizado subquery, e tamb�m UNION.

create view nrClientesPorEstado as
select c.uf, count(cl.Nome) as totalClientes
from cidade c
join cliente cl on c.IDCidade = cl.IDCidade
group by c.uf

select * from nrClientesPorEstado
where totalClientes = (select max(totalClientes) from nrClientesPorEstado) or
	  totalClientes = (select min(totalClientes) from nrClientesPorEstado)

--6) Liste o total de cidades (distintas) que possuem clientes que realizaram algum pedido.
--Dica: ser� preciso relacionar Cidade com Cliente, e Cliente com Pedido

select count(distinct c.nome)
from cidade c
	join cliente cl on c.IDCidade = cl.IDCidade
	join Pedido p on cl.IDCliente = p.IDCliente

/*
7) Dentro da atual estrutura, cada produto � composto por 1 ou v�rios materiais (tabela ProdutoMaterial).
Identifique se existe algum produto sem material relacionado.
Obs.: o produto criado anteriormente dever� ser listado.
*/



/*
8) Liste os produtos, com seu pre�o de custo, e relacione com seus os materiais (ProdutoMaterial), e liste tamb�m
o somat�rio do PrecoCusto de todos seus materiais. Veja um exemplo abaixo:
IDProduto Produto  Preco Custo R$  Preco Custo Materiais R$
1589 Chin Palm 3940  883,74  1.092,02
2253 Salg Plops Presunto  370,88  823,03
3581 Garrafa Madri Rolha  872,43  1.469,31
*/



/*
9) Ap�s identificar o pre�o de custo dos produtos e seus materiais ser� preciso acertar os produtos que est�o com
o valor de custo inferior ao custo dos materiais. Pra isso fa�a uma altera��o (update) na tabela de Produtos,
definindo o PrecoCusto, para que fique igual ao custo dos seus materiais.
*/



--10) Liste os clientes que tenham o mesmo nome (Tabela Cliente, registros com o nome (apenas) duplicado).



--11) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.



--12) Liste qual o produto � mais vendido (considere a informa��o da quantidade).
	