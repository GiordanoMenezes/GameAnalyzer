export type RecordsResponse = {
  content: RecordItem[];
  totalPages: number;
}

export type RecordItem = {
  id: number;
  moment: string;
  name: string;
  age: number;
  game: string;
  platform: Platform;
  genre: string;
}

export type Platform = 'XBOX' | 'PC' | 'PLAYSTATION';