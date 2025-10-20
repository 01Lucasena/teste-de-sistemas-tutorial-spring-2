function Formulario({ botao, eventoTeclado, cadastrar, alterar, remover, cancelar, obj }) {
  return (
    <form>
      <input 
        type="text" 
        onChange={eventoTeclado} 
        name="nome" 
        placeholder="Nome" 
        className="form-control" 
        value={obj.nome} 
      />
      <input 
        type="text" 
        onChange={eventoTeclado} 
        name="marca" 
        placeholder="Marca" 
        className="form-control" 
        value={obj.marca} 
      />

      {
        botao
          ?
          <input type="button" value="Cadastrar" onClick={cadastrar} className="btn btn-primary" />
          :
          <div>
            <input type="button" value="Alterar" onClick={alterar} className="btn btn-warning" />
            <input type="button" value="Remover" onClick={remover} className="btn btn-danger" />
            <input type="button" value="Cancelar" onClick={cancelar} className="btn btn-secondary" />
          </div>
      }
    </form>
  );
}

export default Formulario;