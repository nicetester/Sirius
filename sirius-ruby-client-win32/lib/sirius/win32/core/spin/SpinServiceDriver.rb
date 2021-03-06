require 'SpinService.rb'
require 'SpinServiceMappingRegistry.rb'
require 'soap/rpc/driver'

module Sirius::Client::Win32::Core::Spin


class Spin < ::SOAP::RPC::Driver  DefaultEndpointUrl = "http:localhost:21212/win32/spin"
  Methods = [
    [ "",
      "getLowerBound",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getLowerBound"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getLowerBoundResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "getUpperBound",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getUpperBound"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getUpperBoundResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "getSmallStep",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getSmallStep"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getSmallStepResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "getLargeStep",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getLargeStep"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getLargeStepResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "increment",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "increment"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "incrementResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "getText",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getText"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getTextResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "setText",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "setText"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "setTextResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "decrement",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "decrement"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "decrementResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "getPosition",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getPosition"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "getPositionResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ],
    [ "",
      "setPosition",
      [ [:in, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "setPosition"]],
        [:out, "parameters", ["::SOAP::SOAPElement", "http:controls.classes.win32.server.sirius.org/", "setPositionResponse"]] ],
      { :request_style =>  :document, :request_use =>  :literal,
        :response_style => :document, :response_use => :literal,
        :faults => {} }
    ]
  ]

    def initialize(endpoint_url = nil)  endpoint_url ||= DefaultEndpointUrl
    super(endpoint_url, nil)
    self.mapping_registry = SpinServiceMappingRegistry::EncodedRegistry
    self.literal_mapping_registry = SpinServiceMappingRegistry::LiteralRegistry
    init_methods
  end
private

    def init_methods
      Methods.each do |definitions|
              opt = definitions.last
              if opt[:request_style] == :document
                add_document_operation(*definitions)
              else
                add_rpc_operation(*definitions)
                qname = definitions[0]
                name = definitions[2]
                if qname.name != name and qname.name.capitalize == name.capitalize
                  ::SOAP::Mapping.define_singleton_method(self, qname.name) do |*arg|
                    __send__(name, *arg)
                  end
                end
              end
            end

  end
end

end
