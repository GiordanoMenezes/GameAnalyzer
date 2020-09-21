import React from 'react';

import './pagination.css';

type Props = {
  totalPages?: number;
  gotoPage: Function;
  activePage: number;
}

function Pagination({ totalPages, gotoPage, activePage }: Props) {

  const pagesList = Array.from(Array(totalPages).keys());

  return (
    <div className="pagination-container">
      {pagesList.map(item => {
        return (
          <button key={item} className={`pagination-item ${activePage === item ? 'active' : 'inactive'}`}
            onClick={() => gotoPage(item)}>
            {item + 1}
          </button>
        )
      })}
    </div>
  );
}

export default Pagination;