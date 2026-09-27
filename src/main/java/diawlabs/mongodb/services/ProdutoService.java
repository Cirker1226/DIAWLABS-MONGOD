package diawlabs.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import diawlabs.mongodb.models.Produto;
import diawlabs.mongodb.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(String id) {
    return produtoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Produto não encontrado"
            ));
}

    public Produto atualizarProduto(String id, Produto produto) {
        Produto existente = buscarProdutoPorId(id);

        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());

        return produtoRepository.save(existente);
    }

    public void deletarProduto(String id) {
        buscarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}
