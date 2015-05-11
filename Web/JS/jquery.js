/*1A

Faça uma instrução jQuery que selecione todos elementos com a classe module.
*/

var res = $('.module');

/*
1B

Faça uma instrução jQuery que selecione o terceiro elemento da lista não ordenada myList.
*/

var res = $('#myList > li:eq(2)');

/*
1C

Faça uma instrução jQuery que selecione o label para o input de busca usando um seletor de atributo.
*/

var res = $('label[for=q]');

/*
1D

Escreva uma instrução jQuery que encontre quantos elementos na página tem um atributo alt.
*/

var res = $('[alt]').length;

/*
1E

Faça uma instrução jQuery que selecione todas as linhas pares da tabela com exceção do cabeçalho.
*/

var res = $('#fruits tr:even:not(:first-child)');

/*
1F

Faça uma instrução jQuery que encontre quantos elementos h2 possuem as letras "B", "e" NO MESMO texto.
*/



/*
1G

Faça uma instrução jQuery que selecione todos os li dentro de #myList que não estão vermelhos.

:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Proibido utilizar os pseudo-seletores :eq, :gt ou :lt.

1H

Faça uma instrução jQuery que selecione todos os elementos que são os últimos filhos no HTML do tipo img OU que são os últimos filhos no HTML do tipo h3

1I

Faça uma instrução jQuery que conte o número de caractéres somados dos textos de todos li que estão APÓS o li com fonte vermelha, dentro de #myList. Ex:

<ul id='myList'>
    <li class='current bar'>vermelho</li>
    <li>Azul</li>
    <li>Verde</li>
</ul>
'Azul'.length + 'Verde'.length => 9
:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Não utilize os pseudo-seletores :eq, :gt ou lt!
*/