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

$('h2:contains(B):contains(e)')

/*
1G

Faça uma instrução jQuery que selecione todos os li dentro de #myList que não estão vermelhos.

:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Proibido utilizar os pseudo-seletores :eq, :gt ou :lt.
*/

$("#myList li[class!='current bar']")

/*
1H

Faça uma instrução jQuery que selecione todos os elementos que são os últimos filhos no HTML do 
tipo img OU que são os últimos filhos no HTML do tipo h3
*/

$("html img:last, html h3:last")

/*
1I

Faça uma instrução jQuery que conte o número de caractéres somados dos textos de todos li 
que estão APÓS o li com fonte vermelha, dentro de #myList. Ex:

<ul id='myList'>
    <li class='current bar'>vermelho</li>
    <li>Azul</li>
    <li>Verde</li>
</ul>

'Azul'.length + 'Verde'.length => 9
:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Não utilize os pseudo-seletores :eq, :gt ou lt!
*/

$("#myList li[class='current bar']").next().text().length + $("#myList li[class='current bar']:last").text().length

/*
2A

Faça uma instrução jQuery que selecione todos elementos img da página que possuem alt e os 
imprima no log do console.
*/

console.log($("img[alt]"));

/*
2B

Faça uma instrução jQuery que selecione o input text pelo atributo, depois navegue até seu elemento
 pai e adicione a classe template nele.

:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Não utilize pseudo-seletores e não selecione diretamente o pai do input text.
*/

$("input[type='text']").parent().addClass('template')

/*
2C

Faça uma instrução jQuery que selecione o item de lista dentro de #myList que possui uma 
classe "current" e:
Remova esta classe dele.
Adicione uma classe "current" no próximo item de lista.
:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Faça tudo isso em apenas um encadeamento de chamadas. Ex:

$('select from html where...').funcao1().funcao2().funcao3().funcao4().funcao5();
*/

$("#myList li[class='current bar']").removeClass('current bar').next().addClass('current bar')

/*
2D

Faça uma instrução jQuery que selecione o elemento h2 dentro de #specials, altere seu texto para "Promoções", depois atravesse e altere o texto da opção "Friday" para "Dimitri".

:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Não utilize pseudo-seletores.
Faça tudo isso em apenas um encadeamento de chamadas. Ex:
$('select from html where...').funcao1().funcao2().funcao3().funcao4().funcao5();
*/



/*
2E

Faça uma instrução jQuery que selecione o primeiro item de lista no elemento #slideshow; adicione a classe "current" a ele e então adicione a classe "disabled" para seus elementos sibling.

:warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning::warning:

Não utilize pseudo-seletores.
Faça tudo isso em apenas um encadeamento de chamadas. Ex:
$('select from html where...').funcao1().funcao2().funcao3().funcao4().funcao5();
*/