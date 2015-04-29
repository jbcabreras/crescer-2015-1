/*
1) Imprima qual produto é o mais vendido, considere a quantidade (PedidoItem).
*/

begin
	declare @idproduto int,
			@nome varchar(100),
			@totalItens int
select top 1 with ties --(considera empates)
	@idproduto = PedidoItem.IDProduto,
	@nome = Produto.Nome,
	@totalItens = sum(quantidade) 
from PedidoItem
	join Produto on Produto.IDProduto = PedidoItem.IDProduto
group by PedidoItem.IDProduto, 
	     Produto.Nome
order by sum(quantidade) desc

print 'PRODUTO = ' + @nome + ' / TOTAL VENDIDO = ' + cast(@totalItens as varchar(10))
end;

/* 
2) Liste as cidades com nome e UF duplicados que tenham clientes relacionados.
*/
alter view cidadesComCliente as
select c.nome, c.uf, c.IDCidade
from cidade c
where exists (select 1 from cliente cl where c.idcidade = cl.idcidade)

BEGIN
DECLARE ListaCidade CURSOR
	Local
	Fast_Forward
FOR Select c.Nome, c.Uf
	From Cidade c
	where c.idcidade in (select IDCidade from cidadesComCliente ccc where  )				         

DECLARE @vNome varchar(50),
		@vUF varchar(2)

OPEN ListaCidade;
FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	
	WHILE (@@FETCH_STATUS=0) BEGIN
		Print @vNome + '/'+@vUF;
		FETCH NEXT FROM ListaCidade INTO @vNome, @vUF
	END

CLOSE ListaCidade;
DEALLOCATE ListaCidade;

END

/*
3) Identifique qual o material é utilizado por mais produtos e em seguida liste a quantidade de pedidos realizados, com
produtos compostos por este material, liste também o valor total de vendas dos últimos 60 dias.
*/

select  idmaterial, count(idproduto)
from ProdutoMaterial
group by idmaterial
order by count(IDProduto) desc

select count(distinct p.idPedido) as TotalPedidos
from pedido p
	join PedidoItem pit on p.IDPedido = pit.IDPedido
	join ProdutoMaterial pm on pm.IDProduto = pit.IDProduto
where pm.IDMaterial in (select top 1 with ties idmaterial
							from ProdutoMaterial
					        group by idmaterial
							order by count(IDProduto) desc)
union 

select 


