# Descrição dos Padrões Implementados

## Iterator
- **Classes**: br.com.sistema.iterator.OrderIterator, br.com.sistema.iterator.PedidoCollection
- **Objetivo**: Permitir percorrer a coleção de pedidos sem expor sua estrutura interna.

## Prototype
- **Classes**: br.com.sistema.model.Pedido (implements Cloneable)
- **Objetivo**: Criar cópias profundas de objetos Pedido sem depender de construtores.

## Decorator
- **Classes**: br.com.sistema.decorator.NotificationDecorator, EmailNotifier, SMSNotifier
- **Objetivo**: Adicionar funcionalidades de notificação dinamicamente a instâncias de Notifier.

## Observer
- **Classes**: br.com.sistema.observer.DeliverySubject, DeliveryObserver, ConsoleObserver, EmailObserver
- **Objetivo**: Notificar múltiplos observadores sobre mudanças no estado de entrega.

## Proxy
- **Classes**: br.com.sistema.proxy.MapService, MapServiceProxy
- **Objetivo**: Adicionar camada de cache e controle de acesso ao serviço de mapas.

## Builder
- **Classes**: br.com.sistema.builder.PedidoBuilder, Director
- **Objetivo**: Construir objetos Pedido passo a passo de forma flexível.

## Interpreter
- **Classes**: br.com.sistema.interpreter.Expression, AndExpression, OrExpression, TerminalExpression, InterpreterContext
- **Objetivo**: Avaliar sentenças booleanas no contexto de regras de negócio.

## Visitor
- **Classes**: br.com.sistema.visitor.Visitor, ReportVisitor, ValidationVisitor, accept() em Pedido e Usuario
- **Objetivo**: Separar algoritmos de estruturas de objeto, permitindo extensões sem modificar classes modelo.

## State
- **Classes**: br.com.sistema.state.PaymentState, PendingState, CompletedState, state field em Pagamento
- **Objetivo**: Alterar comportamento de processamento de pagamento dinamicamente conforme estado.

## Strategy
- **Classes**: br.com.sistema.strategy.PaymentStrategy, CreditCardStrategy, PaypalStrategy, strategy field em Pagamento
- **Objetivo**: Encapsular algoritmos de cálculo de taxas de pagamento e torná-los intercambiáveis.
