using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.Birthstones
{
    /// <summary>
    /// Query options for the Birthstones API
    /// </summary>
    public class BirthstonesQueryOptions
    {
        /// <summary>
        /// The month number (1-12) or name (january, february, etc.)
        /// Example: 5
        /// </summary>
        [JsonProperty("month")]
        public string Month { get; set; }
    }
}
