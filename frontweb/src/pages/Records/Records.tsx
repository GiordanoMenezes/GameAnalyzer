import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import Pagination from '../../components/Pagination/Pagination';
import { listRecords } from '../../services/RecordService';
import { formatDate } from '../../services/utils';
import { RecordsResponse } from './Record';

import './Records.css';

function Records(props: any) {

  const [recordsResponse, setRecordsResponse] = useState<RecordsResponse>();
  const [activePage, setActivePage] = useState(0);

  const handlePageChange = (index: number) => {
    setActivePage(index);
  }

  useEffect(() => {
    const load = async () => {
      try {
        const response = await listRecords(activePage);
        setRecordsResponse(response.data);
      } catch (error) {
        console.error(error);
      }
    }
    load();
  }, [activePage]);


  return (
    <div className="page-container">
      <div className="filters-container records-actions">
        <Link to="/charts">
          <button className="action-filters">
            VER GRÁFICOS
          </button>
        </Link>
      </div>
      <table className="records-table" cellPadding="0" cellSpacing="0">
        <thead>
          <tr>
            <th>DATA/HORA</th>
            <th>NOME</th>
            <th>IDADE</th>
            <th>PLATAFORMA</th>
            <th>GÊNERO</th>
            <th>TÍTULO DO GAME</th>
          </tr>
        </thead>
        <tbody>
          {recordsResponse?.content.map(record => {
            return (
              <tr key={record.id}>
                <td>{formatDate(record.moment)}</td>
                <td>{record.name}</td>
                <td>{record.age}</td>
                <td className="text-secondary">{record.platform}</td>
                <td>{record.genre}</td>
                <td className="text-primary">{record.game}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
      <Pagination totalPages={recordsResponse?.totalPages} activePage={activePage} gotoPage={handlePageChange} />
    </div>
  );
}

export default Records;