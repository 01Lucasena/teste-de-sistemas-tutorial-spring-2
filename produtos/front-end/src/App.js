import Formulario from './components/Formulario';
import Tabela from './components/Tabela';
import './App.css';
import { useState } from 'react';

function App() {
  const [btnCadastrar, setBtnCadastrar] = useState(true);
  return (
    <div>
      <Formulario botao = {btnCadastrar}/>
      <Tabela/>
    </div>
  );
}

export default App;
