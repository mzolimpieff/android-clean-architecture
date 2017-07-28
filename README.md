# README #

### Sobre a arquitetura ###

O projeto foi feito em Clean Architecture, onde se tem por objetivo, separar em camadas a aplicação e tornar as regras de negócio da aplicação independentes de view, de framework, de banco de dados, etc.

O [VIPER](https://www.objc.io/issues/13-architecture/viper/) (iOS) surgiu a partir destes conceitos, porém o projeto aqui apresentado leva os conceitos apresentados pelo [Uncle Bob](http://blog.cleancoder.com/) mais à risca. 

### Mas Por Que Clean Architecture? ###

Dado a situação de que o cliente tem algo sólido em relação a sua regra de negócio do que o aplicativo irá fazer e não tem a api para prover isso, A aplicação não deve depender dela. Na verdade, api e banco são apenas **detalhes**. 

Aplicando o clean architecture, cada camada tem uma responsabilidade clara, e assim facilitando muito na hora de implementar **testes** (vide os 2 testes que eu deixei em camadas diferentes como exemplo. existe um no domain e um na camada do app).

### Links de referência para Clean Architecture ###

https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html

https://www.youtube.com/watch?v=Nsjsiz2A9mg