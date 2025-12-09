declare module '@apiverve/birthstones' {
  export interface birthstonesOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface birthstonesResponse {
    status: string;
    error: string | null;
    data: BirthstonesData;
    code?: number;
  }


  interface BirthstonesData {
      month:           number;
      monthName:       string;
      primaryStone:    string;
      alternateStones: string[];
      color:           string;
      meaning:         string;
      zodiacSigns:     string[];
      hardness:        number;
      mineralFamily:   string;
      anniversaryYear: number;
  }

  export default class birthstonesWrapper {
    constructor(options: birthstonesOptions);

    execute(callback: (error: any, data: birthstonesResponse | null) => void): Promise<birthstonesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: birthstonesResponse | null) => void): Promise<birthstonesResponse>;
    execute(query?: Record<string, any>): Promise<birthstonesResponse>;
  }
}
