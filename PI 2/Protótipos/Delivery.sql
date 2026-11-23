use master
go
if db_id('Delivery') is not null
begin
    alter database Delivery set single_user with rollback immediate
    drop database Delivery
end
go


create database Delivery
go
use Delivery
go
create table cliente(
cpf char(11) not null,
nome varchar(255) not null,
email varchar(80) not null,
telefone char(11) not null,
logradouro varchar(80) not null,
numeroEnd int not null,
complemento varchar(30),
primary key(cpf),
constraint chk_cliente_cpf check(len(cpf) = 11),
constraint chk_cliente_telefone check(len(telefone) = 11),
constraint chk_cliente_numEnd check(len(numeroEnd) > 0)
)
go
create table produto(
id int identity(1,1),
descricao varchar(255) not null,
valor decimal(4,2) not null,
quantidade int not null,
primary key(id),
constraint chk_valor_produto check(valor > 0),
constraint chk_qtd_produto check(quantidade > 0)
)
go
create table pedido(
id int identity(1,1),
produtoid int not null,
quantidade int not null default(1),
valorTotal decimal(5,2) not null,
primary key(id),
constraint chk_qtd_pedido check(quantidade > 0),
constraint chk_valor_pedido check(valorTotal > 0.0),
foreign key (produtoId) references produto (id)
)
go

ALTER TABLE produto
ADD nutricao VARCHAR(255) NOT NULL;
go

alter table produto
add nome varchar(255) not null
go


INSERT INTO produto (nome, descricao, valor, quantidade, nutricao)
VALUES
    (
        'Brigadeiro Tradicional',
        'Brigadeiro gourmet feito com chocolate meio amargo e granulado belga',
        4.50,
        50,
        'Porcao 25g: 98 kcal | Carboidratos 13g | Proteinas 1.2g | Gorduras totais 4.5g | Sodio 22mg'
    ),
    (
        'Beijinho de Coco',
        'Doce de coco fresco ralado finalizado com cravo-da-índia',
        4.00,
        40,
        'Porcao 25g: 92 kcal | Carboidratos 12g | Proteinas 1.0g | Gorduras totais 4.2g | Sodio 18mg'
    ),
    (
        'Bolo de Pote Chocolate',
        'Camadas de pão de ló de chocolate com recheio de brigadeiro cremoso',
        14.90,
        25,
        'Porcao 180g: 460 kcal | Carboidratos 54g | Proteinas 6.8g | Gorduras totais 24g | Sodio 145mg'
    ),
    (
        'Torta de Limão',
        'Massa amanteigada crocante com creme de limão siciliano e merengue maçaricado',
        16.50,
        15,
        'Porcao 120g: 340 kcal | Carboidratos 38g | Proteinas 4.1g | Gorduras totais 19g | Sodio 110mg'
    ),
    (
        'Brownie com Nozes',
        'Brownie denso de chocolate 70% cacau com pedaços de nozes tostadas',
        11.00,
        30,
        'Porcao 80g: 310 kcal | Carboidratos 29g | Proteinas 5.2g | Gorduras totais 19.5g | Sodio 65mg'
    );
GO



select * from cliente
select * from pedido
select * from produto

