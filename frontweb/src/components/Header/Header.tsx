import React from 'react';

import './Header.css';

import { ReactComponent as Logo } from '../../assets/images/logo.svg';
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header className="main-header">
      <Link to="/">
        <Logo />
        <div className="logo-text">
          <span className="logo-text-1">Game</span>
          <span className="logo-text-2">Analyzer</span>
        </div>
      </Link>
    </header>
  );
}

export default Header;