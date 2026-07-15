declare module '@apiverve/birthstones' {
  export interface birthstonesOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface birthstonesResponse {
    status: string;
    error: string | null;
    data: BirthstonesData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface BirthstonesData {
      month:           number | null;
      monthName:       null | string;
      primaryStone:    null | string;
      alternateStones: (null | string)[];
      color:           null | string;
      meaning:         null | string;
      zodiacSigns:     (null | string)[];
      hardness:        number | null;
      mineralFamily:   null | string;
      anniversaryYear: number | null;
  }

  export default class birthstonesWrapper {
    constructor(options: birthstonesOptions);

    execute(callback: (error: any, data: birthstonesResponse | null) => void): Promise<birthstonesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: birthstonesResponse | null) => void): Promise<birthstonesResponse>;
    execute(query?: Record<string, any>): Promise<birthstonesResponse>;
  }
}
