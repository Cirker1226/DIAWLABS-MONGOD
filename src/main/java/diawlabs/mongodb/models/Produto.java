package diawlabs.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document indica que essa classe será salva na coleção "produtos"
@Document(collection = "produtos")
public class Produto {

    // @Id indica que este campo é o identificador único do documento no MongoDB
    @Id
    private String id;

    private String nome;

    private double preco;

    // getters e setters
}
